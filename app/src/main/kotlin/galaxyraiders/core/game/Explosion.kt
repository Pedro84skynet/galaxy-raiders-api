package galaxyraiders.core.game

import galaxyraiders.core.physics.Point2D
import galaxyraiders.core.physics.Vector2D

const val STDDURATION = 360

class Explosion(
  initialPosition: Point2D,
  initialVelocity: Vector2D,
  radius: Double,
  mass: Double
) :
  SpaceObject("Explosion", '*', initialPosition, initialVelocity, radius, mass) {

  var isTriggered: Boolean = true
  var duration: Int = STDDURATION

  fun countDown() {
    duration -= 1
    print("duration: $duration")
    if (duration == 0) isTriggered = false
  }
}
