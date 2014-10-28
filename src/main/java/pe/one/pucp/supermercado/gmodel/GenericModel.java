package pe.one.pucp.supermercado.gmodel;

public interface GenericModel {

    Object getId();

    boolean isValidForCreate();

    boolean isValidForUpdate();
}
