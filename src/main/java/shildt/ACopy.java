package shildt;

public class ACopy {
    public static void main(String args[]) {
        int i;
        int nums1[] = new int[10];
        int nums2[] = new int[10];

        for (i = 0; i < nums1.length; i++)
            nums1[i] = i;
        for (i = 0; i < nums1.length; i++)
            System.out.print(nums1[i] + " ");

        System.out.println();

        // Копировать массив numsl в массив nums2
        // Работает только если массивы одинаковые
        if (nums2.length >= nums1.length)
            for (i = 0; i < nums2.length; i++)
                nums2[i] = nums1[i];
        // Исnоnьэованне переменной length
        // дnя сравненняраэмеров массивов
        for (i = 0; i < nums2.length; i++)
            System.out.print(nums2[i] + " ");
    }
}