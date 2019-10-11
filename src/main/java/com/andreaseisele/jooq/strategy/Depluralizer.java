package com.andreaseisele.jooq.strategy;

import org.jibx.schema.codegen.extend.DefaultNameConverter;
import org.jibx.schema.codegen.extend.NameConverter;

class Depluralizer {

    private static final NameConverter NAME_CONVERTER = new DefaultNameConverter();

    static String depluralize(String term) {
        return NAME_CONVERTER.depluralize(term);
    }

}
