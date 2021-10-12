class Main {
    class Item {
        private String Name;
        private Double Price;
        private int plateSize;

        public int getPlateSize() {
            /**
             * I did not get this.
             * the place size is not used in other parts of the code so the logic behind is unknown...
             * there is no clue about this
             */
            return 0;
        }
    }

    class OrderedItem {
        private Item item;
        private Receipt receipt;

        public void serve() {
            int plateSize = item.getPlateSize();
            /**
             * only the plate size was mentioned here.
             * what behavior is expected when it is called ??
             * 1. is there any condition on the plate size ?
             * 2. should it put the ordered item on the receipt or it was already there?
             * 3. there should be information about the order has been served. Is there any specific logic behind ?
             */
        }

        void cancel() {
            receipt = null;
        }

        public Item getItem() {
            return this.getItem();
        }
    }

    class Receipt {
        private ArrayList<OrderedItem> items;
        private int TableNumber;

        public void returnOrderedItem(Item item) {
            Optional<OrderedItem> orderedItem = items.stream()
                    .filter(oItem -> oItem.getItem() == item)
                    .findFirst();
            orderedItem.ifPresent(i ->{
                i.cancel();
                items.remove(i);
            });
        }


        public int getTableNumber() {
            return this.TableNumber;
        }
    }

    class CashRegister {
        public ArrayList<Receipt> receipts;

        public CashRegister() {
            receipts = Lists.newArrayList();
        }

        Receipt searchReceipt(int tableNumber) {
            return receipts.stream()
                    .filter(r -> r.getTableNumber() == tableNumber)
                    .findFirst()
                    .orElse(null);
        }
    }

    class DrinkActionPrice {
        String getDrinkActionPrice() {
            return "30% between 14:00 - 16:00.";
        }
    }

    class MainCourseActionPrice {
        String getMainCourseDiscount() {
            return "20% between 11:00 - 13:00.";
        }
    }

    class ActionPriceManager {
        void processDrinkActionPrice(DrinkActionPrice actionPrice) {
            /**
             * in case of application this discount u need to ensure
             *  1. 30% between 14:00 - 16:00. - devide into attributes discount, from, to
             *  2. it depends if the discount is based on food order time or receipt creation time
             *     according to that it needs to be added some attributes in previous structures
             *  3. provide parameter receipt or meal or drink based on commment number 2 above
             *  the same applies on processMainCourseActionPrice
             */
        }

        void processMainCourseActionPrice(MainCourseActionPrice actionPrice) {...}
    }

    class CrispyChicken extends Item {
        @Override
        public int getPlateSize() {
            return 2;
        }
    }

    class Redbull extends Item {
        @Override
        public int getPlateSize() {
            return 1;
        }
    }

    public interface ItemAction {
        default void returnBackToWaiter(){
            throw  new UnsupportedOperationException();
        }

        default void eat(){
            throw  new UnsupportedOperationException();
        }

        default void drink(){
            throw  new UnsupportedOperationException();
        }
    }

    class CrispyChickenAction implements ItemAction {
        public Item item;

        @Override
        public void returnBackToWaiter() {
            /**
             * there is no waiter object
             * I suppose this should be called after meal or drink is finished
             * but also it can be considered as return of meal that is somehow
             */
        }

        @Override
        public void eat() {}

    }

    class RedbullAction implements ItemAction {
        public Item item;

        @Override
        public void returnBackToWaiter() {
        }

        @Override
        public void drink() { }
    }

    public static CashRegister cashRegister = new CashRegister();

    public static void main(String[] args) throws Exception {
    }
}