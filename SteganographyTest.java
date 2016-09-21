import org.junit.*;
import static org.junit.Assert.*;

public class SteganographyTest {

  ASCII ascii;
  RetrieveMessage retrieve;

  @Before
  public void before() {
    ascii = new ASCII();
    retrieve = new RetrieveMessage();
  }

  @Test
  public void canLoadPicture() {
    
    int[][] imageInPixels = retrieve.loadPicture("stegosaur_embedded.png");
    retrieve.convertToBinary(imageInPixels);
    // assertEquals(ascii.decode(encodedMessage), "a");
  }

  @Test
  public void canEncodeMessageWithSingleLetters() {
    String[] encodedMessage = ascii.encode("a");
    assertEquals(ascii.decode(encodedMessage), "a");
  }

  @Test
  public void canEncodeMessageWithMultipleLetters() {
    String[] encodedMessage = ascii.encode("abc");
    assertEquals(ascii.decode(encodedMessage), "abc");
  }

  @Test
  public void canEncodeMessageWithSingleDigit() {
    String[] encodedMessage = ascii.encode("5");
    assertEquals(ascii.decode(encodedMessage), "5");
  }

  @Test
  public void canEncodeMessageWithMultipleDigits() {
    String[] encodedMessage = ascii.encode("123");
    assertEquals(ascii.decode(encodedMessage), "123");
  }

  @Test
  public void canEncodeMessageWithMixOfCharacters() {
    String[] encodedMessage = ascii.encode("abc1a2b3c");
    assertEquals(ascii.decode(encodedMessage), "abc1a2b3c");
  }

  @Test
  public void canEncodeLongMessage() {
    String[] encodedMessage = ascii.encode("hjghgbrvtyt6 756rv4ecwertyuiubdvrtfyugiyuil;'fdv4d85y4udtrergbt uhjdrgtu4ydtuetdyuienriuetn47ryndregr';[][p]pr[gpt[gpr   []prt[rgt  ffgr  tpt.rr[re;tre[;ptretrseg'.t[roptrth ryutrsehfgyugrdienifighjskfnuew  brguhfjrenryugeishrw4ryt674y8n34bfrigyauywngybguwenhdbsvhzj nkjbfegvrhfubewngyfuieunwsrngiewf ngruhonewrxae      woruyr473485c64  8nr784t8ry4n8r34yr8nt3     8rn94n3u87r49r8y48rtynrjihfndgyfbcerytcourent8erotp[;rlg[pr.lt[prckctp,orct[stsermtcyruntruitgct   slurtycurenctyre  n78ty478c0nrto4t  748c6r78465873465764576378   95637856cnruturtruturtnoicrwtuiui  ryiutyruityerytue    rytiuyeulkjhuytrtyu");
    assertEquals(ascii.decode(encodedMessage), "hjghgbrvtyt6 756rv4ecwertyuiubdvrtfyugiyuil;'fdv4d85y4udtrergbt uhjdrgtu4ydtuetdyuienriuetn47ryndregr';[][p]pr[gpt[gpr   []prt[rgt  ffgr  tpt.rr[re;tre[;ptretrseg'.t[roptrth ryutrsehfgyugrdienifighjskfnuew  brguhfjrenryugeishrw4ryt674y8n34bfrigyauywngybguwenhdbsvhzj nkjbfegvrhfubewngyfuieunwsrngiewf ngruhonewrxae      woruyr473485c64  8nr784t8ry4n8r34yr8nt3     8rn94n3u87r49r8y48rtynrjihfndgyfbcerytcourent8erotp[;rlg[pr.lt[prckctp,orct[stsermtcyruntruitgct   slurtycurenctyre  n78ty478c0nrto4t  748c6r78465873465764576378   95637856cnruturtruturtnoicrwtuiui  ryiutyruityerytue    rytiuyeulkjhuytrtyu");
  }
}