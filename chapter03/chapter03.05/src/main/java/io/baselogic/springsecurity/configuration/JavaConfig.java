package io.baselogic.springsecurity.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * General Spring Configuration.
 * See Other Configs: {@link io.baselogic.springsecurity.configuration.DataSourceConfig}
 * @since chapter01.00
 * @since chapter03.03 added .userdetails package
 * @since chapter03.05 added .authentication package
 */
@Configuration
@ComponentScan(basePackages =
        {
                "io.baselogic.springsecurity"
        }
)
public class JavaConfig {


} // The end...
