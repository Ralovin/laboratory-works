package ki305.vladyka.lab2;

/**
 * Клас зберігає зовнішній вигляд авто.
 */

public class Appearance{
    private String color;
    private String bodyType;
    private boolean hasSunroof;

    /**
     * Конструктор з параметрами.
     * @param color Колір
     * @param bodyType Тип кузова
     * @param hasSunroof Чи є люк
     */

    public Appearance(String color,String bodyType,boolean hasSunroof){
        this.color = color;
        this.bodyType = bodyType;
        this.hasSunroof = hasSunroof;
    }
      /** @return Колір */

    public String getColor(){
        return color;
    }
     /** @return Тип кузова */

    public String getBodyType(){
        return bodyType;
    }
    /** @return Чи є люк */

    public boolean getHasSunroof(){
        return hasSunroof;
    }
    /** @param color Новий колір */

    public void setColor(String color){
        this.color = color;
    }
    /** @param bodyType Новий тип кузова */

    public void setBodyType(String bodyType){
        this.bodyType = bodyType;
    }
    /** @param hasSunroof Встановити наявність люка */

    public void setHasSunroof( boolean hasSunroof){
        this.hasSunroof = hasSunroof;
    }

    

}