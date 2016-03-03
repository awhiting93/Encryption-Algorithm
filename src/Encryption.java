
public class Encryption {
	private final int MAX_INDEXES = 9999;
	private final int ALPHABET1 = 0;
	private final int ALPHABET2 = 1;
	private final int ALPHABET3 = 2;
	
	private final int INITIAL_KEY_VALUE = 0;
	private final int INITIAL_KEY_PT1   = 0;
	private final int INITIAL_KEY_PT2   = 1;
	private final int INITIAL_KEY_PT3   = 2;
	
	String plainText;
	String cipherText;
	String[] key;
	String[] alphabet = new String[]
			{"abeRSTUfg}>.?hijABF$%GH}{:I7890-JK{}\"\'LklmnopWXYq<,QVZ!r234stuv1"
	        + "56={[wxyzMNOPcd]:CDE;<,QVZ!@#^&*()_+/fg}>.mnopWX?h90-JK\"\'GHI7%GH}{:I7890-JK",
	        "eRUYqr2fg}>.$D!%GE;<ST\",QVZ!%GHIABg}7)_890-JpW(+/fX\'GHI34stuv1"
	    	+ "56={[wxa@#^byzMNO?hFPcd]:CK\'Lkzr2flm890-Jpno&*ijABg}>.?h90\'Lkz-JK\"7890-JK",
	    	"}>.$DEABIg}d]:C;<#^P_FPcby/f>.?STHWno-J\'L(_+$cUp%GY&*iI7)_\",QJK\"7+4stuv1"
	    	+ "5wxa@eRqgMNH6={[3O?hABIg}dFP_FPc+$cUp%GY}{STHWn>:KVZ890!klmjX\'Gh90-890-JK"};
	
	public Encryption(){
		this.plainText = "";
		this.cipherText = "";
		this.key = new String[MAX_INDEXES];
	}
	
	public String getPlainText() {
		return plainText;
	}

	public void setPlainText(String plainText) {
		this.plainText = plainText;
		this.key[INITIAL_KEY_VALUE] = Integer.toString(((this.plainText.length() * 2) + 1110) % 1000);
	}

	public String getCipherText() {
		return cipherText;
	}

	public String getKey() {
		StringBuilder returnKey = new StringBuilder("");
		for(String keyValue : this.key){
            if(keyValue != null)
			returnKey.append(keyValue);
		}
		return returnKey.toString();
	}
	
	public String getBaseKey(){
		return getKey().substring(0, 3);
	}
	
	public String getCharacterKey(){
		return getKey().substring(3, getKey().length() - 2).toString();
	}
	
	public String getAlphabetUsed(){
		return getKey().substring(getKey().length() - 1).toString();
	}
	
	public String encrypt(String plainText){
		this.plainText = plainText;
		encrypt();
		return this.cipherText;
	}
	
	public String encrypt(){
		String[] alphabet = new String[]{""};
		int asciiValue;
		int alphabetUsed = 0;
		int keyCounter = 1;
		
		this.cipherText = "";
		int keyValue1 = Integer.parseInt(key[INITIAL_KEY_VALUE].split("")[INITIAL_KEY_PT1]);
		int keyValue2 = Integer.parseInt(key[INITIAL_KEY_VALUE].split("")[INITIAL_KEY_PT2]);
		int keyValue3 = Integer.parseInt(key[INITIAL_KEY_VALUE].split("")[INITIAL_KEY_PT3]);
		
		if((plainText.length() % 3) == 0){
			alphabet = this.alphabet[ALPHABET1].split("");
			alphabetUsed = ALPHABET1 + 1;
		}
		else if((plainText.length() % 3) == 1){
			alphabet = this.alphabet[ALPHABET2].split("");
			alphabetUsed = ALPHABET2 + 1;
		}
		else if((plainText.length() % 3) == 2){
			alphabet = this.alphabet[ALPHABET3].split("");
			alphabetUsed = ALPHABET3 + 1;
		}
		
		for(int currChar = 0; currChar < this.plainText.length(); currChar++){
			asciiValue = ((int)plainText.charAt(currChar) - 20);
			if((currChar % 4) == 0){
				cipherText += (alphabet[asciiValue - (keyValue1 + 2)]);
				this.key[keyCounter] = Integer.toString(asciiValue - (keyValue1 + 2));
				keyCounter++;
				cipherText += (alphabet[asciiValue + (keyValue2 * 2)]);
//				this.key[keyCounter] = Integer.toString(asciiValue + (keyValue2 * 2));
//				keyCounter++;
				cipherText += (alphabet[asciiValue - (keyValue3 - 3)]);
//				this.key[keyCounter] = Integer.toString(asciiValue - (keyValue3 - 3));
//				keyCounter++;
			}
			else if ((currChar % 4) == 1){
				cipherText += (alphabet[asciiValue + (keyValue1 - 5)]);
//				this.key[keyCounter] = Integer.toString(asciiValue + (keyValue1 - 5));
//				keyCounter++;
				
				cipherText += (alphabet[asciiValue - (keyValue2 + 1)]);
				this.key[keyCounter] = Integer.toString(asciiValue - (keyValue2 + 1));
				keyCounter++;
				
				cipherText += (alphabet[asciiValue + (keyValue3 * 2)]);
//				this.key[keyCounter] = Integer.toString(asciiValue + (keyValue3 * 2));
//				keyCounter++;
				
				cipherText += (alphabet[asciiValue + (keyValue2 * 3)]);
//				this.key[keyCounter] = Integer.toString(asciiValue + (keyValue2 * 3));
//				keyCounter++;
			}
			else if ((currChar % 4) == 2){
				cipherText += (alphabet[asciiValue + (keyValue1 * 3)]);
//				this.key[keyCounter] = Integer.toString(asciiValue + (keyValue1 * 3));
//				keyCounter++;
				
				cipherText += (alphabet[asciiValue - (keyValue3 - 3)]);
				this.key[keyCounter] = Integer.toString(asciiValue - (keyValue3 - 3));
				keyCounter++;
			}
			else if ((currChar % 4) == 3){
				cipherText += (alphabet[asciiValue + (keyValue1 * 2)]);
//				this.key[keyCounter] = Integer.toString(asciiValue + (keyValue1 * 2));
//				keyCounter++;
				
				cipherText += (alphabet[asciiValue - (keyValue2 + 2)]);
//				this.key[keyCounter] = Integer.toString(asciiValue + (keyValue2 + 2));
//				keyCounter++;
				
				cipherText += (alphabet[asciiValue + (keyValue3 * 3)]);
//				this.key[keyCounter] = Integer.toString(asciiValue + (keyValue3 * 3));
//				keyCounter++;
				
				cipherText += (alphabet[asciiValue + (keyValue1 - 2)]);
				this.key[keyCounter] = Integer.toString(asciiValue + (keyValue1 - 2));
				keyCounter++;
				
				cipherText += (alphabet[asciiValue - (keyValue3 % 2)]);
//				this.key[keyCounter] = Integer.toString(asciiValue - (keyValue3 % 2));
//				keyCounter++;
			}
		}
		keyCounter = 1;
		this.key[key.length - 1] = Integer.toString(alphabetUsed);
		return this.cipherText;
	}
// This will eventually contain a working decrypt function
/*  length = (key - 110) / 2
	public void decrypt(){
		String[] alphabet = this.alphabet.split("");
		int asciiValue;
		for(int currChar = 1; currChar < this.plainText.length(); currChar++){
			asciiValue = ((int)plainText.charAt(currChar) - 30);
			if((currChar % 2) == 0)
				this.cipherText += (alphabet[asciiValue - 1]);
			else if ((currChar % 2) == 1)
				this.cipherText += (alphabet[asciiValue + 1]);
			this.key += Integer.toString(asciiValue);
		}
		System.out.println("Original Text: " + this.plainText);
		System.out.println("Encrypted Text: " + this.cipherText);
	}
}*/
