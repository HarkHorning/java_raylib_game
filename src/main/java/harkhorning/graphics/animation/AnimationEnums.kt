package harkhorning.graphics.animation

enum class AnimationEnums {
    STANDING,
    WALKING,
    DYING
}

enum class AnimationType {
    SINGLE,
    REPEATING
}

enum class AnimationDirection(val value: Int) {
    RIGHT(1),
    LEFT(-1)
}
