public class HeapSort {
    static Integer[] ksorted = null;
    static int maxSorted = 15;

    public static void findLargest(Integer[] arr) {
        System.out.println("Input list is: " + Arrays.asList(arr));
        int l = arr.length;
        if (ksorted == null) {
            ksorted = new Integer[maxSorted];
            for (int i=0; i<maxSorted; i++) {
                ksorted[i] = arr[i];
            }
            //minimum sorting on the k-array
            for (int i=maxSorted/2; i>=0; i--) {
                buildMinHeap(ksorted, i, maxSorted);
            }
            System.out.println("Input list is: " + Arrays.asList(ksorted));
            //insert the element if larger than the minimum value
            for (int i=maxSorted; i<l; i++) {
                if (arr[i] > ksorted[0]) {
                    ksorted[0] = arr[i];
                    //get the minimum at the root
                    buildMinHeap(ksorted, 0, maxSorted);
                }
            }
        } else {
            //insert into the ksorted at the root, if greater than the minimum.
            for (int i=0; i<l; i++) {
               if (arr[i] > ksorted[0]) {
                   ksorted[0] = arr[i];
                   //get the minimum at the root.
                   buildMinHeap(ksorted, 0, maxSorted);
               }
            }
        }

//        int sortElem = 0;
//        while (sortElem < maxSorted) {
//            swap(arr, 0, l-sortElem-1);
//            ksorted[sortElem] = arr[l-sortElem-1];
//            arr[l-sortElem-1] = null;
//            sortElem++;
//            if (l-sortElem-1!=0) {
//                buildMinHeap(arr, 0, l-sortElem-1);
//            }
//        }
        System.out.println("Sorted list is: " + Arrays.asList(ksorted));
    }

    public static void buildMinHeap(Integer[] arr, int idx, int total) {
        if(idx>total/2) {
            return;
        }
        int l = 2*idx +1;
        int r = l+1;
        int min = findMin(arr, l, r, idx, total);
        if (min == l) {
            swap(arr, l, idx);
            if(l<arr.length/2) {
                buildMinHeap(arr, l, total);
            }
        }
        if (min == r) {
            swap(arr, r, idx);
            if (r < arr.length/2) {
                buildMinHeap(arr, r, total);
            }
        }
    }

    public static int findMin(Integer[] arr, int l, int r, int idx, int total) {
        int smallest = idx;
        if (l<total) {
            if (arr[l] < arr[smallest]) {
                smallest = l;
            }
        }
        if (r<total) {
            if (arr[r] < arr[smallest]) {
                smallest = r;
            }
        }
        return smallest;
    }

    public static void swap(Integer[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void getIntegers(@NotNull InputStream is) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                String[] strarr = line.split(",");
                Integer[] intarr = new Integer[strarr.length];
//                System.out.println("Number of elements is " +intarr.length);
                int i = -1;
                for(String s: strarr) {
                    if (!s.isEmpty()) {
                        intarr[++i] = Integer.parseInt(s.trim());
                    }
                }
                if(intarr.length>1) {
                    findLargest(intarr);
                }
                line = br.readLine();
            }
//            printLargest();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public static void main(String [] args) {
        URL url  = HeapSort.class.getResource("heap_input.txt");
        File f = new File(url.getFile());
        InputStream is = null;
        try {
            is = new FileInputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        getIntegers(is);
    }
}
