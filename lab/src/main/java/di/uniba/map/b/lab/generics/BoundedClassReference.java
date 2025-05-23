/*
 * Copyright (C) 2020 pierpaolo
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package di.uniba.map.b.lab.generics;

/**
 *
 * @author pierpaolo
 */
public class BoundedClassReference {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Class<? extends Number> bounded = int.class;
        bounded = double.class;
        bounded = Number.class;
        //bounded = String.class; // compile-time error
        
        Holder3<String> h1=new Holder3<>("pippo");
        Holder3<?> h2=new Holder3<>(43);
        h2=new Holder3<>("sdklfjldsk");
        Holder3<? extends Number> h3=new Holder3<>(3);
    }
}
