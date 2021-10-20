/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2021

 Last modified 10/12/21, 12:52 AM
 */

package cl.figonzal.evaluatool.model

//Menu Header
data class Header(val name: String, var expanded: Boolean = false)

//Child Item
data class Child(val name: String)