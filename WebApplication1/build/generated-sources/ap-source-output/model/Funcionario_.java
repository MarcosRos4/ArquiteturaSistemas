package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Departamento;
import model.Usuario;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-09-01T11:00:36")
@StaticMetamodel(Funcionario.class)
public class Funcionario_ { 

    public static volatile SingularAttribute<Funcionario, String> nomefuncionario;
    public static volatile SingularAttribute<Funcionario, String> cargofuncionario;
    public static volatile SingularAttribute<Funcionario, String> telefonefuncionario;
    public static volatile SingularAttribute<Funcionario, Departamento> departamento;
    public static volatile SingularAttribute<Funcionario, Usuario> usuario;
    public static volatile SingularAttribute<Funcionario, Double> salariofuncionario;
    public static volatile SingularAttribute<Funcionario, String> emailfuncionario;

}