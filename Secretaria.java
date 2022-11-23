import ru.glebmavi.lab3.Personaje;


public class Secretaria extends Personaje implements Caller {

    public Secretaria() {
        super();
    }

    public Secretaria(String name) {
        super(name);
    }


    @Override
    public String toString() {
        return this.getClass() + " {" + "name = '" + name + '\'' + ", como = " + this.getComoTitles() + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Secretaria comp = (Secretaria) obj;
        return name.equals(comp.name) && como.equals(comp.como);

    }

    @Override
    public int hashCode() {
        int result = 7;
        if (name != null) {
            result = 13 * result + name.hashCode();
        }
        if (como != null) {
            result = 13 * result + como.hashCode();
        }
        return result;
    }

    @Override
    public String call(Personaje p) {
        String a = "Я вызываю вас " + p.getName() + "!";
        System.out.println("Секретарша " + this.name + " сказала: Я вызываю вас " + p.getName() + "!");
        return a;
    }
}
