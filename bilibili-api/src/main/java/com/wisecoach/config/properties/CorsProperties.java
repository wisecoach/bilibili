package com.wisecoach.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author wisecoach
 */
@Data
@ConfigurationProperties(prefix = "cors")
public class CorsProperties {
    private String[] origins;
}
