package com.cloudcoders.gestaca.persistance;

import java.util.List;

public interface DAL {

  public List<Class> listAll(Class t);
  public Class getOne(Class t);
  public void insertOne(Class t, Object o);
  public void removeOne(Class t, Object o);
  public void updateOne(Class t, Object o);

}
