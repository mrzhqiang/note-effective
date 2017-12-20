package com.github.mrzhqiang.sample2;

public class NutritionFacts {
  private final int servingSize;  // ml   required
  private final int servings;     // per  container required
  private final int calories;     //      optional
  private final int fat;          // g    optional
  private final int sodium;       // mg   optional
  private final int carbohydrate; // g    optional

  public NutritionFacts(int servingSize, int servings) {
    this(servingSize, servings, 0);
  }

  public NutritionFacts(int servingSize, int servings, int calories) {
    this(servingSize, servings, calories, 0);
  }

  public NutritionFacts(int servingSize, int servings, int calories, int fat) {
    this(servingSize, servings, calories, fat, 0);
  }

  public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium) {
    this(servingSize, servings, calories, fat, sodium, 0);
  }

  public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium,
      int carbohydrate) {
    this.servingSize = servingSize;
    this.servings = servings;
    this.calories = calories;
    this.fat = fat;
    this.sodium = sodium;
    this.carbohydrate = carbohydrate;
  }

  NutritionFacts(Builder builder) {
    this.servingSize = builder.servingSize;
    this.servings = builder.servings;
    this.calories = builder.calories;
    this.fat = builder.fat;
    this.sodium = builder.sodium;
    this.carbohydrate = builder.carbohydrate;
  }

  @Override public String toString() {
    return "[NutritionFacts]:"
        + " servingSize="
        + servingSize
        + ", servings="
        + servings
        + ", calories="
        + calories
        + ", fat=" + fat + ", sodium=" + sodium + ", carbohydrate=" + carbohydrate;
  }

  public static class Builder {
    private final int servingSize;  // ml   required
    private final int servings;     // per  container required

    private int calories;     //      optional
    private int fat;          // g    optional
    private int sodium;       // mg   optional
    private int carbohydrate; // g    optional

    public Builder(int servingSize, int servings) {
      this.servingSize = servingSize;
      this.servings = servings;
    }

    public Builder calories(int calories) {
      this.calories = calories;
      return this;
    }

    public Builder fat(int fat) {
      this.fat = fat;
      return this;
    }

    public Builder sodium(int sodium) {
      this.sodium = sodium;
      return this;
    }

    public Builder carbohydrate(int carbohydrate) {
      this.carbohydrate = carbohydrate;
      return this;
    }

    public NutritionFacts build() {
      return new NutritionFacts(this);
    }
  }
}
