package gui;

import java.util.function.Predicate;


/**
 *
 * @author User
 */
public interface ManagementInterface<T> {
    public void print(Predicate<T> condition);
    public boolean addObject(T object);
    public boolean removeObject(T object);
    public boolean updateObject(T before, T after);
    public boolean checkExists(T object);
    public T search(String key);
    public boolean save();
    public boolean load();
    public int getIndex(T object);
}
