package com.psdorofeev;

public class Test
{
    public static void test()
    {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }

    private static void test1()
    {
        int[][] input1 = new int[][]{{8, 3, 4},
            {4, 8, 12},
            {9, 5, 6},
            {2, 8, 3},
            {12, 3, 5},
            {1, 4, 12}};

        assert (88 == Solution.getMax(input1, 4));
    }

    private static void test2()
    {
        int[][] input1 = new int[][]{{8, 3, 4},
            {4,0,44},
            {4,4,4},
            {1,3,5},
            {5,4,11}};

        assert (92 == Solution.getMax(input1, 4));
    }

    private static void test3()
    {
        int[][] input1 = new int[][]{};

        assert (0 == Solution.getMax(input1, 4));
    }

    private static void test4()
    {
        int[][] input1 = new int[][]{{1,1,5}};

        assert (0 == Solution.getMax(input1, 4));
    }

    private static void test5()
    {
        int[][] input1 = new int[][]{{2,1,7},
            {5,5,5}};

        assert (0 == Solution.getMax(input1, 4));
    }

    private static void test6()
    {
        int[][] input1 = new int[][]{{2,3,6},
            {5,5,5}};

        assert (15 == Solution.getMax(input1, 5));
    }
}
