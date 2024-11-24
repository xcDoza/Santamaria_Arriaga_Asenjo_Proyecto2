package proyecto2;

import Clases.NodoTree;
import Clases.Persona;

public class HashTable implements IHashTable {

    static final int max = 53; // Tamaño máximo de la tabla hash
    private int size;
    private NodoTree[] table;

    public HashTable() {
        this.size = 0;
        this.table = new NodoTree[max];
    }

    @Override
    public NodoTree get(String key, boolean mote) {
        int position = hash(key, mote);
        NodoTree person = table[position];
        System.out.println(((Persona) person.getElement()).getNombre());
        Persona persona = (Persona) person.getElement();
        // Verificar si la persona en la posición coincide con la clave proporcionada
        if (persona != null) {
            String expectedKey = persona.getNombre() + persona.getNumeric();
            if (expectedKey.equalsIgnoreCase(key) || persona.getApodo().equalsIgnoreCase(key)) {
                return person;
            }
        }
        return null; // Retornar null si no hay coincidencia
    }

    @Override
    public void remove(String key) {
        int position = hash(key, false);
        if (table[position] != null) {
            table[position] = null;
            size--;
        }
    }

    @Override
    public void add(NodoTree person, boolean mote) {
        Persona persona = (Persona) person.getElement();
        String key = mote ? persona.getApodo() : persona.getNombre() + persona.getNumeric();
        int position = hash(key, mote);

        if (table[position] == null) {
            table[position] = person;
            size++;
            System.out.println("Aniadido a la posicion: " + position + " con clave: " + key);
        } else {
            // Resolución de colisiones usando prueba cuadrática
            int i = 1;
            while (table[position] != null) {
                position = (position + i * i) % max;
                i++;
            }
            table[position] = person;
            size++;
            System.out.println("Aniadido a la posicion (despues de colision): " + position + " con clave: " + key);
        }
    }

    /**
     * Vacía todos los nodos de la tabla hash.
     */
    public void clear() {
        for (int i = 0; i < max; i++) {
            table[i] = null; // Elimina el nodo de cada posición
        }
        size = 0; // Reinicia el tamaño de la tabla a 0
        System.out.println("La tabla hash ha sido vaciada.");
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getMax() {
        return max;
    }

    //con esto obtenemos el array table
    public NodoTree[] getTable() {
        return table;
    }

    /**
     * Método hash para calcular la posición en la tabla
     *
     * @param key Clave para hashear
     * @param mote Indica si la clave es un mote o un nombre completo + número
     * @return Posición en la tabla
     */
    @Override
    public int hash(String key, boolean mote) {
        long hashValue = transformString(key); // Genera el valor hash a partir de la clave
        int position = (int) (hashValue % max);
        return position;
    }

    /**
     * Transforma un String en un valor numérico para el hash
     *
     * @param key String a transformar
     * @return Valor hash
     */
    @Override
    public long transformString(String key) {
        long hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash * 31) + key.charAt(i); // Función hash base 31
        }
        return Math.abs(hash);
    }

    @Override
    public String[] getMatch(String key, boolean mote) {
        String[] matches = new String[0];
        String[] matches2;
        for (NodoTree person : table) {
            matches2 = matches;
            if (person != null) {
                Persona element = (Persona) person.getElement();
                if (mote) {
                    if (element != null && element.getApodo().toLowerCase().contains(key.toLowerCase())) {
                        matches2 = new String[matches.length + 1];
                        for (int i = 0; i < matches.length; i++) {
                            matches2[i] = matches[i];
                        }
                        matches = matches2;
                        matches[matches.length - 1] = element.getApodo();
                    }
                } else {
                    if (element != null && (element.getNombre() + element.getNumeric()).toLowerCase().contains(key.toLowerCase())) {
                        matches2 = new String[matches.length + 1];
                        for (int i = 0; i < matches.length; i++) {
                            matches2[i] = matches[i];
                        }
                        matches = matches2;
                        matches[matches.length - 1] = element.getNombre() + element.getNumeric();
                    }
                }
            }
        }
        return matches;
    }
}
