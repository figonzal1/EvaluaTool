/*

 This file is subject to the terms and conditions defined in
 file 'LICENSE', which is part of this source code package

 Autor: Felipe González
 Email: felipe.gonzalezalarcon94@gmail.com

 Copyright (c) 2022

 Last modified 27/2/22 22:04
 */

package cl.figonzal.evaluatool.domain.model

//Menu Header
data class Header(val name: String, var expanded: Boolean = false)

//Child Item
data class Child(val name: String)