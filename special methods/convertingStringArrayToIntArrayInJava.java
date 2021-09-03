// Short hand Java 8 technique

Scanner scan = new Scanner(System.in);
int[] arr = Arrays.stream(scan.nextLine()
                                      .trim()
                                      .split(" "))
                                      .mapToInt(Integer::parseInt)
                                      .toArray();
