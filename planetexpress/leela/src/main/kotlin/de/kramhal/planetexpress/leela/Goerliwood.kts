package de.kramhal.planetexpress.leela

fun printGörliwoodMayor(name : String, age : Int = 0,
                   salary : Double = 0.0) =
        println("$name is $age and earns $salary GU (Goldunzen)")

printGörliwoodMayor("Gottlob Ludwig Demiani", 47, 3000.0)
// printGörliwoodMayor(47,"Gottlob Ludwig Demiani", 3000.00) // bOOm
printGörliwoodMayor(age = 47, name = "Gottlob Ludwig Demiani", salary = 3000.0)
printGörliwoodMayor(name ="Georg Snay", age = 45)
//printGörliwoodMayor(3000.0)
