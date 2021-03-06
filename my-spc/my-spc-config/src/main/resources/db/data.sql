INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('demo', 'default', 'master', 'app.greet.name', 'Demo');

-- eureka server
INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('eureka-server', 'default', 'master', 'server.port', '${SERVER_PORT:8010}');

INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('eureka-server', 'default', 'master', 'eureka.instance.preferIpAddress', 'true');
INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('eureka-server', 'default', 'master', 'eureka.instance.lease-renewal-interval-in-seconds', '10');
INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('eureka-server', 'default', 'master', 'eureka.instance.lease-expiration-duration-in-seconds', '30');

INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('eureka-server', 'default', 'master', 'eureka.server.waitTimeInMsWhenSyncEmpty', '0');
INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('eureka-server', 'default', 'master', 'eureka.server.enableSelfPreservation', 'false');
INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('eureka-server', 'default', 'master', 'eureka.server.eviction-interval-timer-in-ms', '10000');

INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('eureka-server', 'default', 'master', 'eureka.client.registerWithEureka', 'false'); //-- 注册自身
INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('eureka-server', 'default', 'master', 'eureka.client.fetchRegistry', 'false');
INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('eureka-server', 'default', 'master', 'eureka.client.serviceUrl.defaultZone', 'http://${EUREKA_SERVER_HOST:127.0.0.1}:${EUREKA_SERVER_PORT:8010}/eureka/');

-- gateway
INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('gateway', 'default', 'master', 'server.port', '${SERVER_PORT:8000}');
INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('gateway', 'default', 'master', 'eureka.instance.preferIpAddress', 'true');
INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('gateway', 'default', 'master', 'eureka.instance.lease-renewal-interval-in-seconds', '10');
INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('gateway', 'default', 'master', 'eureka.instance.lease-expiration-duration-in-seconds', '30');
INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('gateway', 'default', 'master', 'eureka.client.registerWithEureka', 'true');
INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('gateway', 'default', 'master', 'eureka.client.fetchRegistry', 'true');
INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('gateway', 'default', 'master', 'eureka.client.serviceUrl.defaultZone', 'http://${EUREKA_SERVER1_HOST:127.0.0.1}:${EUREKA_SERVER1_PORT:8010}/eureka/');

-- turbine
INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('turbine', 'default', 'master', 'turbine.appConfig', 'gateway,biz-service');
INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('turbine', 'default', 'master', 'server.port', '${SERVER_PORT:8001}');
INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('turbine', 'default', 'master', 'eureka.instance.preferIpAddress', 'true');
INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('turbine', 'default', 'master', 'eureka.instance.lease-renewal-interval-in-seconds', '10');
INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('turbine', 'default', 'master', 'eureka.instance.lease-expiration-duration-in-seconds', '30');
INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('turbine', 'default', 'master', 'eureka.client.registerWithEureka', 'true');
INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('turbine', 'default', 'master', 'eureka.client.fetchRegistry', 'true');
INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('turbine', 'default', 'master', 'eureka.client.serviceUrl.defaultZone', 'http://${EUREKA_SERVER1_HOST:127.0.0.1}:${EUREKA_SERVER1_PORT:8010}/eureka/');

-- spring-admin
INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('spring-admin', 'default', 'master', 'server.port', '${SERVER_PORT:8002}');
INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('spring-admin', 'default', 'master', 'eureka.instance.preferIpAddress', 'true');
INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('spring-admin', 'default', 'master', 'eureka.instance.lease-renewal-interval-in-seconds', '10');
INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('spring-admin', 'default', 'master', 'eureka.instance.lease-expiration-duration-in-seconds', '30');
INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('spring-admin', 'default', 'master', 'eureka.client.registerWithEureka', 'true');
INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('spring-admin', 'default', 'master', 'eureka.client.fetchRegistry', 'true');
INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('spring-admin', 'default', 'master', 'eureka.client.serviceUrl.defaultZone', 'http://${EUREKA_SERVER1_HOST:127.0.0.1}:${EUREKA_SERVER1_PORT:8010}/eureka/');

-- biz-service
INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('biz-service', 'default', 'master', 'server.port', '${SERVER_PORT:8003}');
INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('biz-service', 'default', 'master', 'eureka.instance.preferIpAddress', 'true');
INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('biz-service', 'default', 'master', 'eureka.instance.lease-renewal-interval-in-seconds', '10');
INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('biz-service', 'default', 'master', 'eureka.instance.lease-expiration-duration-in-seconds', '30');
INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('biz-service', 'default', 'master', 'eureka.client.registerWithEureka', 'true');
INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('biz-service', 'default', 'master', 'eureka.client.fetchRegistry', 'true');
INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('biz-service', 'default', 'master', 'eureka.client.serviceUrl.defaultZone', 'http://${EUREKA_SERVER1_HOST:127.0.0.1}:${EUREKA_SERVER1_PORT:8010}/eureka/');

-- web
INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('web', 'default', 'master', 'server.port', '${SERVER_PORT:8004}');
INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('web', 'default', 'master', 'eureka.instance.preferIpAddress', 'true');
INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('web', 'default', 'master', 'eureka.instance.lease-renewal-interval-in-seconds', '10');
INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('web', 'default', 'master', 'eureka.instance.lease-expiration-duration-in-seconds', '30');
INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('web', 'default', 'master', 'eureka.client.registerWithEureka', 'true');
INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('web', 'default', 'master', 'eureka.client.fetchRegistry', 'true');
INSERT INTO PROPERTIES (APPLICATION, PROFILE, LABEL, KEY, VALUE)
VALUES ('web', 'default', 'master', 'eureka.client.serviceUrl.defaultZone', 'http://${EUREKA_SERVER1_HOST:127.0.0.1}:${EUREKA_SERVER1_PORT:8010}/eureka/');