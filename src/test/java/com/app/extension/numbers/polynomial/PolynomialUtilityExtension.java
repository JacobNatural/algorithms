package com.app.extension.numbers.polynomial;

import com.app.numbers.polynomial.Polynomial;
import com.app.numbers.polynomial.PolynomialUtility;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class PolynomialUtilityExtension implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().equals(PolynomialUtility.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return new PolynomialUtility(Polynomial.of(new double[]{3.5,-2.5,2.0,-4.0}));
    }
}
