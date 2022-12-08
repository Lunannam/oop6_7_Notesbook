package model;

public class Note {
        private String id = "";
        private String date;
        private String title;
        private String bodyNote;
    
        public Note(String date, String title, String bodyNote) {
            this.date = date;
            this.title = title;
            this.bodyNote = bodyNote;
        }
    
        public Note(String id, String date, String title, String bodyNote) {
            this(date, title, bodyNote);
            this.id = id;
        }
    
        public String getId() {
            return id;
        }
    
        public void setId(String id) {
            this.id = id;
        }
    
        public String getDate() {
            return date;
        }
    
        public void setDate(String date) {
            this.date = date;
        }
    
        public String getTitle() {
            return title;
        }
    
        public void setTitle(String title) {
            this.title = title;
        }
    
        public String getBodyNote() {
            return bodyNote;
        }
    
        public void setBodyNote(String bodyNote) {
            this.bodyNote = bodyNote;
        }
    
        @Override
        public String toString() {
            return String.format("# : %s\n Date: %s,\nTitle: %s,\n Comment: %s", id, date, title, bodyNote);
        }
    
    
    }
       

