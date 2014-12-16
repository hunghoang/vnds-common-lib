## VNDS common lib

    1. Velocity template builder
       + use velocity 1.7
    
    2. Wrap OracleDAOHelper from web-lib to a mockable class
       + use spring-jdbc, ojdbc14
       
    3. Load input stream from file in absolute directory or current class loader
    
    4. Load properties sequential
    
    5. Clean HTML tag
    
    6. Convert UNICODE text to ASCII

    7. Generate Unique Queue Key
       + using spring-context version 3.1.4-RELEASE
    
## BUILD
    
    1. mvn clean install
    
## How to use
    1. Generate Unique Queue Key: configure spring bean example
```
    <bean id="generateQueueKey" class="vn.com.vndirect.lib.commonlib.properties.GenerateUniqueKey">
        <property name="generatedPropertyName" value="[params_in_properties_file]"></property>
    </bean>
    <bean id="propertyConfigurer" class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer" depends-on="generateQueueKey">
        <property name="locations">
            <list>
                <value>WEB-INF/configs/queue.properties</value>
            </list>
        </property>
    </bean> 
```
    
    Note: using **depend-on** with initializing propertyConfigurer
    