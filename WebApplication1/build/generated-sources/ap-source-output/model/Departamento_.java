package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Funcionario;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-09-01T11:00:36")
@StaticMetamodel(Departamento.class)
public class Departamento_ { 

    public static volatile SingularAttribute<Departamento, String> nomedepartamento;
    public static volatile ListAttribute<Departamento, Funcionario> funcionarioList;
    public static volatile SingularAttribute<Departamento, String> telefonedepartamento;
    public static volatile SingularAttribute<Departamento, String> iddepartamento;

}