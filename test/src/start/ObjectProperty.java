package start;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ObjectProperty {
	
	private  StringProperty word;
	private  StringProperty meaning;

	public ObjectProperty(String word, String meaning) {
        this.word = new SimpleStringProperty(word);
        this.meaning =new SimpleStringProperty(meaning);
	}
	
	public ObjectProperty(SimpleStringProperty word, SimpleStringProperty meaning) {
		this.word=word;
		this.meaning=meaning;
	}


	public String getWord() {
		return word.get();
	}
	
	public void setWord(StringProperty word) {
		this.word=word;
	}
	
    public StringProperty wordProperty() {
        return word;
    }
	
	public String getMeaning() {
		return meaning.get();
	}
	public void setMeaning(StringProperty meaning) {
		this.meaning=meaning;
	}
	
    public StringProperty meaningProperty() {
        return meaning;
    }
}
