public class Plant {

    Size size;
    int damage;


    enum Size {
        SM("Маленький"),
        MD("Средний"),
        BG("Большой"),
        EN("Огромный");

        private final String title;

        Size(String t) {
            this.title = t;
        }
        public String getTitle() {
            return title;
        }

    }

    Plant(Size s, int d) throws PlantNegativeDamageException {
        if (d <= 0) throw new PlantNegativeDamageException("ОШИБКА: Урон растения " + s + " должен быть больше 0");
        this.size = s;
        this.damage = d;
        // la mismisima y unica clase local que en verdad es una aberracion y la funcionalidad es casi nula (en este caso)
        class Power {
            int multiplier;
            String desc;

            Power(Size s) {
                switch (s) {
                    case SM -> {
                        this.multiplier = 1;
                        this.desc = "Слабый";
                    }
                    case MD -> {
                        this.multiplier = 2;
                        this.desc = "Обычный";
                    }
                    case BG -> {
                        this.multiplier = 4;
                        this.desc = "Сыльный";
                    }
                    case EN -> {
                        this.multiplier = 10;
                        this.desc = "Очень сильный";
                    }


                }
            }

            public int applyMult() {
                return damage * multiplier;
            }

            public String getDesc() {
                return desc;
            }
        }
        Power p = new Power(s);
        this.damage = p.applyMult();
    }

    Plant(Size s) {
        this.size = s;
        this.damage = 10;
        class Power {
            int multiplier;
            String desc;

            Power(Size s) {
                switch (s) {
                    case SM -> {
                        this.multiplier = 1;
                        this.desc = "Слабый";
                    }
                    case MD -> {
                        this.multiplier = 2;
                        this.desc = "Обычный";
                    }
                    case BG -> {
                        this.multiplier = 4;
                        this.desc = "Сыльный";
                    }
                    case EN -> {
                        this.multiplier = 10;
                        this.desc = "Очень сильный";
                    }


                }
            }

            public int applyMult() {
                return damage * multiplier;
            }

            public String getDesc() {
                return desc;
            }
        }
        Power p = new Power(s);
        this.damage = p.applyMult();

    }

    class PlantNegativeDamageException extends Exception{
        public PlantNegativeDamageException(String msg){
            super(msg);
        }
    }

    @Override
    public String toString() {
        return this.getClass() + " {" + "size = '" + this.size + '\'' + ", damage = '" + this.damage + '\'' + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Plant comp = (Plant) obj;
        return size.equals(comp.size) && this.damage == comp.damage;

    }

    @Override
    public int hashCode() {
        int result = 7;
        if (size != null) {
            result = 13 * result + size.hashCode();
        }
        return result + 11 * this.damage;
    }

}
