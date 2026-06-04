package sc.android.basiclocalplayerpractice.utils

fun timeConversion(ms: Long): String{
    val totalSeconds = ms/100
    val minutes = totalSeconds / 60
    val seconds = totalSeconds % 60

    return "%d:%02d".format(minutes,seconds)
}