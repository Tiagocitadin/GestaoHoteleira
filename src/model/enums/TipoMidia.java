package model.enums;

public enum TipoMidia {
    IMAGEM,
    VIDEO,
    outro;

    public static TipoMidia fromString(String tipo) {
        for (TipoMidia tipoMidia : TipoMidia.values()) {
            if (tipoMidia.name().equalsIgnoreCase(tipo)) {
                return tipoMidia;
            }
        }
        throw new IllegalArgumentException("No enum constant model.enums.TipoMidia." + tipo);
    }
}
