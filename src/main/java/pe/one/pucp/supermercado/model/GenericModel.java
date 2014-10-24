package pe.one.pucp.supermercado.model;

public interface GenericModel {

    Object getId();

    boolean isValidForCreate();

    boolean isValidForUpdate();
}
