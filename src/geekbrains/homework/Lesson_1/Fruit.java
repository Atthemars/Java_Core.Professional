package geekbrains.homework.Lesson_1;

abstract class Fruit {
    private final float weight;

    Fruit(float weight){
        this.weight = weight;
    }
    float getWeight(){
        return weight;
    }
}
