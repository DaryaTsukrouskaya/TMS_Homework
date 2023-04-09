package by.teachmeskills.homework.hw_31032023.collection;

import java.io.ObjectOutputStream;

public class CustomCollection<T> {
    private T[] array;
    private T temp;
    private boolean freePlace = false;

    public CustomCollection() {
        this.array = (T[]) new Object[1];
    }

    public CustomCollection(int length) {
        this.array = (T[]) new Object[length];
    }

    public void add(int index, T element) {
        if (index >= array.length) {
            T[] newArray = (T[]) new Object[index + 1];
            for (int i = 0; i <= array.length - 1; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
            freePlace = true;
        } else {
            for (int i = array.length - 1; i == 0; i--) {
                if (array[i] == null) {
                    freePlace = true;
                    break;
                }
            }
        }
        if (!freePlace) {
            T[] newArray2 = (T[]) new Object[array.length + 1];
            for (int i = 0; i <= array.length - 1; i++) {
                newArray2[i] = array[i];
            }
            array = newArray2;
        }
        for (int i = index; i < array.length - 1; i++) {
            temp = array[i + 1];
            array[i + 1] = array[index];
            array[index] = temp;
        }
        array[index] = element;
    }

    public void delete(int index) {
        if (index < array.length && array[index] != null) {
            if (index == array.length - 1) {
                array[index] = null;
            } else {
                for (int i = index; i < array.length - 1; i++) {
                    array[i] = array[i + 1];
                }
            }
            T[] newArray = (T[]) new Object[array.length - 1];
            for (int i = 0; i < array.length - 1; i++) {
                if (i == index) {
                    continue;
                }
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    public T get(int index) {
        try {
            return array[index];
        } catch (NullPointerException | IndexOutOfBoundsException exc) {
            System.out.println(exc.getMessage());
        }
        return null;
    }

    public boolean elementExists(T element) {
        for (int i = 0; i <= array.length - 1; i++) {
            if (array[i] != null && array[i].toString().equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void deleteArray() {
        array = null;
    }
}

