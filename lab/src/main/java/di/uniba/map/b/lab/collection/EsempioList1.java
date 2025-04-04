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
package di.uniba.map.b.lab.collection;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pierpaolo
 */
public class EsempioList1 {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("a");
        System.out.println(list);
        list.set(0, "z");
        System.out.println(list);
        list.add(3, "d");
        System.out.println(list);
        System.out.println(list.get(1));
        list.remove(2);
        System.out.println(list);
        System.out.println(list.indexOf("a"));
        list.add("a");
        System.out.println(list);
        System.out.println(list.lastIndexOf("a"));
    }

}
