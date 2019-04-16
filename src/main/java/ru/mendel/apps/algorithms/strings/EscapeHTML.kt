package ru.mendel.apps.algorithms.strings

object EscapeHTML {

    fun escape(s: String):String {
        val out = StringBuilder(Math.max(16, s.length));
        for (i in 0 until s.length){
            val c = s[i]
            when (c){
                '\"' ->{
                    out.append("&");
                    out.append("quot")
                    out.append(';')
                }
                '«' ->{
                    out.append("&");
                    out.append("laquo")
                    out.append(';')
                }
                '»' ->{
                    out.append("&");
                    out.append("raquo")
                    out.append(';')
                }
                '&' ->{
                    out.append("&");
                    out.append("amp")
                    out.append(';')
                }
                '<' ->{
                    out.append("&");
                    out.append("lt")
                    out.append(';')
                }
                '>' ->{
                    out.append("&");
                    out.append("gt")
                    out.append(';')
                }
                else -> out.append(c)
            }
        }
        return out.toString();
    }

}