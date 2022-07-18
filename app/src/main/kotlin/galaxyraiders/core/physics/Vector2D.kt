package galaxyraiders.core.physics

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties("unit", "normal", "degree", "magnitude")
data class Vector2D(val dx: Double, val dy: Double) {
  override fun toString(): String {
    return "Vector2D(dx=$dx, dy=$dy)"
  }

  val magnitude: Double
    get() = Math.sqrt(this * this)

  val radiant: Double
    get() = if (dx >= 0) Math.atan(dy / dx)
    else if (dy >= 0) (Math.PI + Math.atan(dy / dx))
    else -(Math.PI - Math.atan(dy/dx))

  val degree: Double
    get() = Math.toDegrees(this.radiant)

  val unit: Vector2D
    get() = Vector2D(
      this.dx / this.magnitude,
      this.dy / this.magnitude
    )

  val normal: Vector2D
    get() = Vector2D(this.dy / this.magnitude, -this.dx / this.magnitude)

  operator fun times(scalar: Double): Vector2D {
    return Vector2D(this.dx * scalar, this.dy * scalar)
  }

  operator fun div(scalar: Double): Vector2D {
    return Vector2D(this.dx / scalar, this.dy / scalar)
  }

  operator fun times(v: Vector2D): Double {
    return (this.dx * v.dx + this.dy * v.dy)
  }

  operator fun plus(v: Vector2D): Vector2D {
    return Vector2D(this.dx + v.dx, this.dy + v.dy)
  }

  operator fun plus(p: Point2D): Point2D {
    return Point2D(this.dx + p.x, this.dy + p.y)
  }

  operator fun unaryMinus(): Vector2D {
    return Vector2D(-this.dx, -this.dy)
  }

  operator fun minus(v: Vector2D): Vector2D {
    return Vector2D(this.dx - v.dx, this.dy - v.dy)
  }

  fun scalarProject(target: Vector2D): Double {
    return (this * target.unit)
  }

  fun vectorProject(target: Vector2D): Vector2D {
    return target.unit * this.scalarProject(target)
  }
}

operator fun Double.times(v: Vector2D): Vector2D {
  return Vector2D(v.dx * this, v.dy * this)
}
