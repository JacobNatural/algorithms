package com.app.extension.numbers.sieve_eratosthenes;

import com.app.numbers.sieve_eratosthenes.SieveEratosthenes;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

/**
 * The type Sieve eratosthenes extension.
 */
public class SieveEratosthenesExtension implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().equals(SieveEratosthenes.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return SieveEratosthenes.of(500);
    }
}
