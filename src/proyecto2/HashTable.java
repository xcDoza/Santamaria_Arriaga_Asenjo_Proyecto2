package proyecto2;

import Clases.Persona;

public class HashTable implements IHashTable {

    static final int max = 53; // Tamaño máximo de la tabla hash
    private int size;
    private Persona[] table;

    public HashTable() {
        this.size = 0;
        this.table = new Persona[max];
    }

    @Override
    public Persona get(String key, boolean mote) {
        int position = hash(key, false);
        Persona persona = table[position];

        // Verificar si la persona en la posición coincide con la clave proporcionada
        if (persona != null && (persona.getMote().equalsIgnoreCase(key) || (persona.getNombre() + persona.getNumeric()).equalsIgnoreCase(key))) {
            return persona;
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
    public void add(Persona person, boolean mote) {
        String key = mote ? person.getMote() : person.getNombre() + person.getNumeric();
        int position = hash(key, mote);

        if (table[position] == null) {
            table[position] = person;
            size++;
        } else {
            // Resolución de colisiones usando prueba cuadrática
            int i = 1;
            while (table[position] != null) {
                position = (position + i * i) % max;
                i++;
            }
            table[position] = person;
            size++;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getMax() {
        return max;
    }

    /**
     * Método hash para calcular la posición en la tabla
     * @param key Clave para hashear
     * @param mote Indica si la clave es un mote o un nombre completo + número
     * @return Posición en la tabla
     */
    @Override
    public int hash(String key, boolean mote) {
        long hashValue = transformString(key); // Genera el valor hash a partir de la clave
        int position = (int) (hashValue % max);

        // Prueba cuadrática en caso de colisión
        int i = 0;
        String auxKey;
        do {
            Persona persona = table[position];
            if (persona == null) break;

            auxKey = mote ? persona.getMote() : persona.getNombre() + persona.getNumeric();
            if (auxKey.equalsIgnoreCase(key)) break;

            i++;
            position = (position + i * i) % max;
        } while (table[position] != null);

        return position;
    }

    /**
     * Transforma un String en un valor numérico para el hash
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
}
