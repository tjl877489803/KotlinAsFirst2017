@file:Suppress("UNUSED_PARAMETER")
package lesson2.task1

import lesson1.task1.discriminant

/**
 * Пример
 *
 * Найти наименьший корень биквадратного уравнения ax^4 + bx^2 + c = 0
 */
fun minBiRoot(a: Double, b: Double, c: Double): Double {
    // 1: в главной ветке if выполняется НЕСКОЛЬКО операторов
    if (a == 0.0) {
        if (b == 0.0) return Double.NaN // ... и ничего больше не делать
        val bc = -c / b
        if (bc < 0.0) return Double.NaN // ... и ничего больше не делать
        return -Math.sqrt(bc)
        // Дальше функция при a == 0.0 не идёт
    }
    val d = discriminant(a, b, c)   // 2
    if (d < 0.0) return Double.NaN  // 3
    // 4
    val y1 = (-b + Math.sqrt(d)) / (2 * a)
    val y2 = (-b - Math.sqrt(d)) / (2 * a)
    val y3 = Math.max(y1, y2)       // 5
    if (y3 < 0.0) return Double.NaN // 6
    return -Math.sqrt(y3)           // 7
}

/**
 * Простая
 *
 * Мой возраст. Для заданного 0 < n < 200, рассматриваемого как возраст человека,
 * вернуть строку вида: «21 год», «32 года», «12 лет».
 */
fun ageDescription(age: Int): String = when{
    (age % 10 == 1) && (age !in 5..20) && (age !in 111..119)  -> "$age год"
    (age % 10 in 2..4) && (age !in 5..20) && (age !in 111..119) ->"$age года"
    (age % 10 in 5..9) || (age in 5..20) || (age in 111..119) || (age % 10 ==0) ->"$age лет"
    else -> "несуществующая возраст $age"
}




/**
 * Простая
 *
 * Путник двигался t1 часов со скоростью v1 км/час, затем t2 часов — со скоростью v2 км/час
 * и t3 часов — со скоростью v3 км/час.
 * Определить, за какое время он одолел первую половину пути?
 */
fun timeForHalfWay(t1: Double, v1: Double,
                   t2: Double, v2: Double,
                   t3: Double, v3: Double): Double = when {
    (t1 * v1 + t2 * v2 + t3 * v3) / 2 in 0.0..(t1 * v1) -> (t1 * v1 + t2 * v2 + t3 * v3) / 2 / v1
    (t1 * v1 + t2 * v2 + t3 * v3) / 2 in (t1 * v1)..(t1 * v1 + t2 * v2) -> ((t1 * v1 + t2 * v2 + t3 * v3) / 2 - (t1 * v1))/ v2 + t1
    (t1 * v1 + t2 * v2 + t3 * v3) / 2 in (t1 * v1 + t2 * v2)..(t1 * v1 + t2 * v2 + t3 * v3) -> ((t1 * v1 + t2 * v2 + t3 * v3) / 2 - (t1 * v1) - (t2 * v2))/ v3 + t1 + t2
    else -> 0.0
}

/**
 * Простая
 *
 * Нa шахматной доске стоят черный король и две белые ладьи (ладья бьет по горизонтали и вертикали).
 * Определить, не находится ли король под боем, а если есть угроза, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от первой ладьи, 2, если только от второй ладьи,
 * и 3, если угроза от обеих ладей.
 * Считать, что ладьи не могут загораживать друг друга
 */
fun whichRookThreatens(kingX: Int, kingY: Int,
                       rookX1: Int, rookY1: Int,
                       rookX2: Int, rookY2: Int): Int = when {
    (rookX1 == kingX || rookY1 == kingY) && (rookX2 == kingX || rookY2 == kingY) -> 3
    (rookX1 == kingX || rookY1 == kingY) && (rookX2 != kingX && rookY2 != kingY) -> 1
    (rookX1 != kingX && rookY1 != kingY) && (rookX2 == kingX || rookY2 == kingY) -> 2
     rookX1 != kingX && rookY1 != kingY && rookX2 != kingX && rookY2 != kingY -> 0
    else ->100
}

/**
 * Простая
 *
 * На шахматной доске стоят черный король и белые ладья и слон
 * (ладья бьет по горизонтали и вертикали, слон — по диагоналям).
 * Проверить, есть ли угроза королю и если есть, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от ладьи, 2, если только от слона,
 * и 3, если угроза есть и от ладьи и от слона.
 * Считать, что ладья и слон не могут загораживать друг друга.
 */
fun rookOrBishopThreatens(kingX: Int, kingY: Int,
                          rookX: Int, rookY: Int,
                          bishopX: Int, bishopY: Int): Int = TODO()

/**
 * Простая
 *
 * Треугольник задан длинами своих сторон a, b, c.
 * Проверить, является ли данный треугольник остроугольным (вернуть 0),
 * прямоугольным (вернуть 1) или тупоугольным (вернуть 2).
 * Если такой треугольник не существует, вернуть -1.
 */
fun triangleKind(a: Double, b: Double, c: Double): Int {
    if((a + b <= c) || (a + c <= b) || (b + c <= a)) return -1
    else if((a >= b)&&(a >= c))
           if(a * a < b * b + c * c) return 0
           if(a * a == b * b + c * c) return 1
           if(a * a > b * b + c * c) return 2

    if((b >= a)&&(b >= c))
            if(b * b < a * a + c * c) return 0
        if(b * b == a * a + c * c) return 1
        if(b * b > a * a + c * c) return 2

    if((c >= b)&&(c >= a))
        if(c * c < b * b + a * a) return 0
        if(c * c == b * b + a * a) return 1
        if(c * c > b * b + a * a) return 2

    else return 3
}

/**
 * Средняя
 *
 * Даны четыре точки на одной прямой: A, B, C и D.
 * Координаты точек a, b, c, d соответственно, b >= a, d >= c.
 * Найти длину пересечения отрезков AB и CD.
 * Если пересечения нет, вернуть -1.
 */
fun segmentLength(a: Int, b: Int, c: Int, d: Int): Int = TODO()
