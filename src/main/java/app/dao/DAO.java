package app.dao;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {
  List<T> getAll();

  Optional<T> getByID(int ID);

  boolean delete(int ID);

  boolean save();
}
