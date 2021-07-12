package cn.bobz.myspcoauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenStore tokenStore;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore) //指定token存储到redis
                .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.allowFormAuthenticationForClients(); //允许表单认证
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        /*
        授权码模式
        http://localhost:8080/oauth/authorize?response_type=code&client_id=client&redirect_uri=http://www.baidu.com&scope=all
        简化模式
        http://localhost:8080/oauth/authorize?response_type=token&client_id=client&redirect_uri=http://www.baidu.com&scope=all
        */

        /*
                clients.inMemory()
                        //配置client_id
                        .withClient("client")
                        //配置client-secret
                        .secret(passwordEncoder.encode("111111"))
                        //配置访问token的有效期
                        .accessTokenValiditySeconds(3600)
                        //配置刷新token的有效期
                        .refreshTokenValiditySeconds(864000)
                        //配置redirect_uri，用于授权成功后跳转
                        .redirectUris("http://www.baidu.com")
                        //配置申请的权限范围
                        .scopes("all")
                        //配置grant_type，表示授权类型
                        .authorizedGrantTypes("authorization_code","implicit")

                        .and()
                        //配置client_id
                        .withClient("client1")
                        //配置client-secret
                        .secret(passwordEncoder.encode("111111"))
                        //配置访问token的有效期
                        .accessTokenValiditySeconds(3600)
                        //配置刷新token的有效期
                        .refreshTokenValiditySeconds(864000)
                        //配置redirect_uri，用于授权成功后跳转
                        .redirectUris("http://www.163.com")
                        //配置申请的权限范围
                        .scopes("all")
                        //配置grant_type，表示授权类型
                        .authorizedGrantTypes("authorization_code","implicit");
        */

        //该处可以从数据库初始化
        configClients(clients, Arrays.asList(
                new ClientConfig("client", "111111", 3600, 864000, "http://www.baidu.com", "all", new String[]{"authorization_code","implicit"}),
                new ClientConfig("client1", "111111", 3600, 864000, "http://www.163.com", "all", new String[]{"authorization_code","implicit"})
        ));

        clients.withClientDetails();
    }

    private void configClients(ClientDetailsServiceConfigurer clients, List<ClientConfig> clientConfigList) throws Exception {
        Assert.notNull(clients, "");
        Assert.notEmpty(clientConfigList, "");
        InMemoryClientDetailsServiceBuilder clientDetailsServiceBuilder = clients.inMemory();
        for (ClientConfig cc : clientConfigList) {
            clientDetailsServiceBuilder
                    .withClient(cc.getClientName())
                    .secret(passwordEncoder.encode(cc.getSecret()))
                    .accessTokenValiditySeconds(cc.getAccessTokenValiditySeconds())
                    .refreshTokenValiditySeconds(cc.getRefreshTokenValiditySeconds())
                    .redirectUris(cc.getRedirectUris())
                    .scopes(cc.getScopes())
                    .authorizedGrantTypes(cc.getAuthorizedGrantTypes());
        }
    }

    public static final class ClientConfig{

        private String clientName;
        private String secret;
        private int accessTokenValiditySeconds;
        private int refreshTokenValiditySeconds;
        private String redirectUris;
        private String scopes;
        private String[] authorizedGrantTypes;

        public ClientConfig(){}

        public ClientConfig(String clientName, String secret, int accessTokenValiditySeconds, int refreshTokenValiditySeconds, String redirectUris, String scopes, String[] authorizedGrantTypes) {
            this.clientName = clientName;
            this.secret = secret;
            this.accessTokenValiditySeconds = accessTokenValiditySeconds;
            this.refreshTokenValiditySeconds = refreshTokenValiditySeconds;
            this.redirectUris = redirectUris;
            this.scopes = scopes;
            this.authorizedGrantTypes = authorizedGrantTypes;
        }

        public String getClientName() {
            return clientName;
        }

        public void setClientName(String clientName) {
            this.clientName = clientName;
        }

        public String getSecret() {
            return secret;
        }

        public void setSecret(String secret) {
            this.secret = secret;
        }

        public int getAccessTokenValiditySeconds() {
            return accessTokenValiditySeconds;
        }

        public void setAccessTokenValiditySeconds(int accessTokenValiditySeconds) {
            this.accessTokenValiditySeconds = accessTokenValiditySeconds;
        }

        public int getRefreshTokenValiditySeconds() {
            return refreshTokenValiditySeconds;
        }

        public void setRefreshTokenValiditySeconds(int refreshTokenValiditySeconds) {
            this.refreshTokenValiditySeconds = refreshTokenValiditySeconds;
        }

        public String getRedirectUris() {
            return redirectUris;
        }

        public void setRedirectUris(String redirectUris) {
            this.redirectUris = redirectUris;
        }

        public String getScopes() {
            return scopes;
        }

        public void setScopes(String scopes) {
            this.scopes = scopes;
        }

        public String[] getAuthorizedGrantTypes() {
            return authorizedGrantTypes;
        }

        public void setAuthorizedGrantTypes(String[] authorizedGrantTypes) {
            this.authorizedGrantTypes = authorizedGrantTypes;
        }
    }
}
