package com.dh.gatewayservice.config;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;
@Component
public class CountFilter extends AbstractGatewayFilterFactory<CountFilter.Config> {

    public static final Logger LOG = Logger.getLogger(CountFilter.class.getName());
    private static AtomicInteger count = new AtomicInteger();

    public CountFilter() {
        super(Config.class);
    }


    @Override
    public GatewayFilter apply(CountFilter.Config config) {
        return (exchange, chain) -> {

            LOG.info("El numero de Request es: " + count.incrementAndGet());

            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            }));
        };
    }
    public static class Config {}
}
