package ru.job4j.ex;

public class FindEl {

    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int index = 0; index < value.length; index++) {
            if (value[index].equals(key)) {
                rsl = index;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Элемент не найдкен!!");
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] str = {"puma", "addidas", "nike"};
        try {
            System.out.println(FindEl.indexOf(str, "nike"));

        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
