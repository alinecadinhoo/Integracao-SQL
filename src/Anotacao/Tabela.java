package Anotacao;

import java.lang.annotation.*;

public @interface Tabela {

    String value();

    @Documented
    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ColunaTabela {

        String dbName();

        String setJavaName();
    }

}
