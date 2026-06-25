# LEARNING.md

# Homework 2 – Learning Log

**Course:** Development Tools  
**Topic:** Learning Unit Testing in Java using ChatGPT

---

# Conversation 1 – What is Unit Testing in Java?

## Me

אני סטונדט בשנה הראשונה בתואר הנדסת תוכנה. תסביר לי מה זה בדיקת יחידה בשפת Java ולמה הן חשובות?

---

## ChatGPT

בדיקות יחידה (Unit Tests) הן אחת המיומנויות החשובות ביותר בפיתוח תוכנה. כמעט כל פרויקט Java מקצועי משתמש בהן, בדרך כלל באמצעות הספרייה JUnit.

### מהי בדיקת יחידה (Unit Test)?

בדיקת יחידה היא תוכנית קטנה שבודקת האם יחידת קוד אחת (Unit) עובדת כפי שהיא אמורה.

בדרך כלל, יחידת הקוד היא:

- מתודה (Method)
- פונקציה
- מחלקה קטנה

המטרה היא לבדוק כל חלק בנפרד, בלי להפעיל את כל התוכנית.

לדוגמה, אם יש מחלקה שמחשבת סכום:

```java
public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }
}
```

נרצה לבדוק שהמתודה `add()` באמת מחזירה את התוצאה הנכונה.

### איך נראית בדיקת יחידה?

באמצעות JUnit:

```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    public void testAdd() {

        Calculator calc = new Calculator();

        int result = calc.add(5, 3);

        assertEquals(8, result);
    }
}
```

### מה קורה כאן?

- יוצרים אובייקט מסוג `Calculator`.
- מפעילים את המתודה.
- שומרים את התוצאה.
- בודקים שהתוצאה היא 8.

אם היא 8 → הבדיקה עוברת ✅

אם היא לא 8 → הבדיקה נכשלת ❌

### מה פירוש "Unit"?

Unit היא יחידת הקוד הקטנה ביותר שניתן לבדוק.

לדוגמה:

```text
Program
│
├── Class A
│     ├── method1()
│     ├── method2()
│
├── Class B
│     ├── method3()
│     └── method4()
```

אפשר לכתוב בדיקה לכל אחת מהמתודות בנפרד.

### למה בדיקות יחידה חשובות?

#### 1. מגלות באגים מוקדם

אם שינית קוד בטעות:

```java
public int add(int a, int b) {
    return a - b;
}
```

הבדיקה מיד תיכשל.

במקום לגלות את התקלה אחרי שבוע, תדע עליה תוך שניות.

---

#### 2. מונעות שבירת קוד קיים (Regression)

נניח שיש לך 200 פונקציות.

אתה משנה אחת מהן.

איך תדע שלא שברת משהו אחר?

פשוט מריצים את כל בדיקות היחידה.

אם כולן עוברות — יש סיכוי גבוה שהשינוי לא גרם לתקלות במקומות אחרים.

---

#### 3. חוסכות זמן

בלי בדיקות:

- להריץ את כל התוכנה
- ללחוץ על כל הכפתורים
- לבדוק ידנית

עם Unit Tests:

```text
Run Tests
↓

200 בדיקות רצות ב-3 שניות

↓

הכול תקין
```

---

#### 4. נותנות ביטחון לבצע שינויים

מפתחים לא מפחדים לשפר קוד (Refactoring), כי אם משהו נשבר – הבדיקות יזהו זאת.

---

#### 5. משפרות את איכות הקוד

כשכותבים בדיקות, לעיתים מגלים שהקוד מסובך מדי.

זה מעודד לכתוב קוד:

- קטן יותר
- ברור יותר
- קל יותר לתחזוקה

---

### איך JUnit יודעת מה לבדוק?

באמצעות האנוטציה:

```java
@Test
```

לדוגמה:

```java
@Test
public void testMultiply() {

}
```

JUnit מריצה כל מתודה שמסומנת ב-`@Test`.

---

### Assertions

Assertions הן בדיקות שמשוות בין התוצאה בפועל לבין התוצאה הצפויה.

דוגמאות נפוצות:

```java
assertEquals(5, result);
```

בודק שהתוצאה היא 5.

```java
assertTrue(number > 0);
```

בודק שהתנאי נכון.

```java
assertFalse(isEmpty);
```

בודק שהתנאי שקרי.

```java
assertNull(object);
```

בודק שהאובייקט הוא `null`.

```java
assertNotNull(object);
```

בודק שהאובייקט אינו `null`.

---

### דוגמה מלאה

מחלקה:

```java
public class BankAccount {

    private int balance = 0;

    public void deposit(int amount) {
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }
}
```

בדיקה:

```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

    @Test
    public void depositShouldIncreaseBalance() {

        BankAccount account = new BankAccount();

        account.deposit(100);

        assertEquals(100, account.getBalance());
    }
}
```

הבדיקה מוודאת שלאחר הפקדת 100, היתרה היא 100.

---

### יתרונות

- גילוי באגים מוקדם.
- מאפשרים לבצע שינויים בביטחון.
- מקטינים את הסיכון לשבירת קוד קיים.
- חוסכים זמן בבדיקות ידניות.
- משפרים את איכות הקוד.
- מספקים תיעוד חי של ההתנהגות המצופה מהקוד.
- מקלים על עבודה בצוות.

### חסרונות

- דורשים זמן כתיבה ותחזוקה.
- יש לעדכן את הבדיקות כאשר הקוד משתנה.
- אינם מבטיחים שהתוכנה כולה עובדת יחד בצורה תקינה (לשם כך יש בדיקות אינטגרציה ובדיקות מערכת).
- כתיבת בדיקות לא טובות עלולה ליצור תחושת ביטחון שגויה.

---

### Unit Test לעומת Integration Test

| Unit Test | Integration Test |
|------------|------------------|
| בודקת מתודה או מחלקה אחת | בודקת כמה רכיבים שעובדים יחד |
| מהירה מאוד | איטית יותר |
| אינה תלויה בדרך כלל במסד נתונים או ברשת | יכולה להשתמש במסד נתונים, API או שירותים אחרים |
| מאתרת תקלות נקודתיות | מאתרת בעיות באינטראקציה בין רכיבים |

---

### סיכום

בדיקות יחידה הן בדיקות אוטומטיות שמוודאות שכל יחידת קוד (לרוב מתודה או מחלקה) מתנהגת כפי שמצופה. ב-Java נהוג לכתוב אותן באמצעות JUnit, תוך שימוש ב-`@Test` וב-Assertions כמו `assertEquals()` ו-`assertTrue()`. הן מסייעות לאתר באגים מוקדם, לשמור על יציבות המערכת בעת שינויים ולשפר את איכות הקוד, ולכן הן חלק בלתי נפרד מפיתוח תוכנה מודרני.

---
