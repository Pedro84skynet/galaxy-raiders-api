package galaxyraiders.core.physics

data class Point2D(val x: Double, val y: Double) {
  operator fun plus(p: Point2D): Point2D {
    return Point2D(x + p.x, y + p.y)
  }

  operator fun plus(v: Vector2D): Point2D {
    return Point2D(x + v.dx, y + v.dy)
  }

  override fun toString(): String {
    return "Point2D(x=$x, y=$y)"
  }

  fun toVector(): Vector2D {
    return Vector2D(this.x, this.y)
  }

  fun impactVector(p: Point2D): Vector2D {
    return Vector2D(Math.abs(x - p.x), Math.abs(y - p.y))
  }

  fun impactDirection(p: Point2D): Vector2D {
    return Vector2D(
      Math.abs(x - p.x) / Math.sqrt(Math.pow(Math.abs(x - p.x), 2.0) + Math.pow(Math.abs(y - p.y), 2.0)),
      Math.abs(y - p.y) / Math.sqrt(Math.pow(Math.abs(x - p.x), 2.0) + Math.pow(Math.abs(y - p.y), 2.0))
    )
  }

  fun contactVector(p: Point2D): Vector2D {
    return Vector2D(
      Math.abs(y - p.y) / Math.sqrt(Math.pow(Math.abs(x - p.x), 2.0) + Math.pow(Math.abs(y - p.y), 2.0)),
      -Math.abs(x - p.x) / Math.sqrt(Math.pow(Math.abs(x - p.x), 2.0) + Math.pow(Math.abs(y - p.y), 2.0))
    )
  }

  fun contactDirection(p: Point2D): Vector2D {
    return Vector2D(
      Math.abs(y - p.y) / Math.sqrt(Math.pow(Math.abs(x - p.x), 2.0) + Math.pow(Math.abs(y - p.y), 2.0)),
      -Math.abs(x - p.x) / Math.sqrt(Math.pow(Math.abs(x - p.x), 2.0) + Math.pow(Math.abs(y - p.y), 2.0))
    )
  }

  fun distance(p: Point2D): Double {
    return Math.sqrt(Math.pow(Math.abs(this.y - p.y), 2.0) + Math.pow(Math.abs(this.x - p.x), 2.0))
  }
}
