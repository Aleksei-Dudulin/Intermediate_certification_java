import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        addContact("Алексей", "11111111");
        addContact("Игорь", "22222222");
        addContact("Денис", "33333333");
        addContact("Алексей", "44444444");
        addContact("Игорь", "55555555");
        addContact("Игорь", "66666666");
        addContact("Алексей", "77777777");
        System.out.println(getSortPhoneBook());
    }

    static HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();

    public static void addContact(String name, String phoneNum) {
        if (phoneBook.containsKey(name)) {
            ArrayList<String> numbers = phoneBook.get(name);
            numbers.add(phoneNum);

        } else {
            ArrayList<String> numbers = new ArrayList<>();
            numbers.add(phoneNum);
            phoneBook.put(name, numbers);
        }

    }

    public static HashMap<String, ArrayList<String>> getSortPhoneBook() {
        List<Map.Entry<String, ArrayList<String>>> entriesPhoneBook = new ArrayList<>(phoneBook.entrySet());
        entriesPhoneBook.sort(new Comparator<Map.Entry<String, ArrayList<String>>>() {

            @Override
            public int compare(Map.Entry<String, ArrayList<String>> o1, Map.Entry<String, ArrayList<String>> o2) {
                return Integer.compare(o2.getValue().size(), o1.getValue().size());
            }
        });

        LinkedHashMap<String, ArrayList<String>> sortedPhoneBook = new LinkedHashMap<>();
        for (Map.Entry<String, ArrayList<String>> entry : entriesPhoneBook) {
            sortedPhoneBook.put(entry.getKey(), entry.getValue());
        }
        return sortedPhoneBook;
    }
}
