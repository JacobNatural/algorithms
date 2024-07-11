package com.app.extension.numbers.polynomial;

import com.app.numbers.polynomial.Polynomial;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import java.util.List;

public class PolynomialsExtension implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().equals(List.class );
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return List.of(
                Polynomial.of(new double[]{3.0,2.5,2.0}),
                Polynomial.of(new double[]{6.0,3.5,4.5,7.5}),
                        Polynomial.of(new double[]{2.5,5.5,-3.5,1.5,-4.5}));
    }
}
