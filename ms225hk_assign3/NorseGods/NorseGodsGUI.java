package ms225hk_assign3.NorseGods;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class NorseGodsGUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        ArrayList<NorseGod> gods = new ArrayList<>();


        gods.add(new NorseGod("Odin", "Aesir", "Odin is the chief divinity of the Norse pantheon, the foremost of the Aesir. Odin is a son of Bor and Bestla. He is called Alfadir, Allfather, for he is indeed father of the gods. With Frigg he is the father of Balder, Hod, and Hermod. He fathered Thor on the goddess Jord; and the giantess Grid became the mother of Vidar.\n" +
                "\n" +
                "Odin is a god of war and death, but also the god of poetry and wisdom. He hung for nine days, pierced by his own spear, on the world tree. Here he learned nine powerful songs, and eighteen runes. Odin can make the dead speak to question the wisest amongst them. His hall in Asgard is Valaskjalf (\"shelf of the slain\") where his throne Hlidskjalf is located."));
        gods.add(new NorseGod("Thor", "Aesir", "Thor is the Norse god of thunder. He is generally depicted as red-headed and bearded.\n" +
                "\n" +
                "He is a son of Odin and Jord, and one of the most powerful gods. He is married to Sif, a fertility goddess. His mistress is the giantess Jarnsaxa (\"iron cutlass\"), and their sons are Magni and Modi and his daughter is Thrud.\n" +
                "\n" +
                "Thor is helped by Thialfi, his servant and the messenger of the gods. who is Hermes in Greek Mythology and Mercury in Roman Mythology.\n" +
                "\n" +
                "Thor was usually portrayed as a large, powerful man with a red beard and eyes of lighting. Despite his ferocious appearance, he was very popular as the protector of both gods and humans against the forces of evil. He even surpassed his father Odin in popularity because, contrary to Odin, he did not require human sacrifices."));
        gods.add(new NorseGod("Loki", "Giant", "In the comic books, Loki is the adopted brother, and arch-nemesis, of Thor but in Norse mythology he is the son of Laufey and the Jötunn Fárbauti and is Odin's blood brother. He is known as the God of Trickery and Mischief and The Father of Monsters.\n" +
                "\n" +
                "He sired the vicious wolf Fenrir and the serpent Jörmungandr as well as Odin's eight-legged horse Sleipnir. He's also the father of the Goddess Hel who reigns over the realm of the dead.\n" +
                "\n" +
                "Loki is not usually considered one of the Æsir, due to his trickery. He caused, amongst other things, the death of Baldr, and the Æsir can never be sure whether he's assisting them or hindering them."));
        gods.add(new NorseGod("Baldr", "Aesir", "The god of light, joy, purity, beauty, innocence, and reconciliation. Son of Odin and Frigg, he was loved by both gods and men and was considered to be the best of the gods. He had a good character, was friendly, wise and eloquent, although he had little power.\n" +
                "\n" +
                "His wife was Nanna daughter of Nep, and their son was Forseti, the god of justice. Balder's hall was Breidablik (\"broad splendor\"). Nanna is linked with the Sumerian goddess Inanna.\n" +
                "\n" +
                "Most of the stories about Balder concern his death. He had been dreaming about his death, so Frigg extracted an oath from every creature, object and force in nature (snakes, metals, diseases, poisons, fire, etc.) that they would never harm Balder. All agreed that none of their kind would ever hurt or assist in hurting Balder. Thinking him invincible, the gods enjoyed themselves thereafter by using Balder as a target for knife-throwing and archery."));
        gods.add(new NorseGod("Freyr", "Vanir", "In Norse mythology, Freya is a goddess of love and fertility, and the most beautiful and propitious of the goddesses. She is the patron goddess of crops and birth, the symbol of sensuality and was called upon in matters of love. She loves music, spring and flowers, and is particularly fond of the elves (fairies). Freya is one of the foremost goddesses of the Vanir.\n" +
                "\n" +
                "Goddess of sex, battle, and pleasure, most beautiful and desirable of white-armed women, Freyja was sister to the male fertility god Freyr. Freyja had unusual parity with Odin, for they divided the heroic dead amongst themselves. Half went to live eternally in Odin's hall, and half in Freyja's hall Sessrumnir- and the goddess got first pick.\n" +
                "\n" +
                "As befits a goddess, Freyja owned potent magical equipment. Like Frigg, she possessed a falcon skin, which when pulled over her shoulders, allowed her to take the form of that raptor.This also provided a useful disguise when needed - important to a goddess whose personage made her instantly recognisable."));
        gods.add(new NorseGod("Freyja", "Vanir", "She´s kind of like the female version of Odin, a little slutty, super independent, and a doer of black magic. She´s the wife of a lost, wondering man, which some have assumed to be Odin, which means she is the same goddess as Frigg, the wife of  Óðinn. She has a beautiful golden necklace called Brisingamen, and wears a bird costume once in a while. She takes the dead who Odinn doesn't want, the ones who don't die as courageous warriors. She also likes boars like Freyr, and has her own wild pig named Hildisvín, and rides in a carriage pulled by cats. If that doesn't make her a crazy cat lady, then I don´t know what would..."));
        gods.add(new NorseGod("Heimdallr", "Aesir", "Heimdall is the god of light, the son of nine mothers (variously given as the daughters of Geirrendour the Giant or of Aegir).\n" +
                "\n" +
                "He was born at the end of the world and raised by the force of the earth, seawater and the blood of a boar.\n" +
                "\n" +
                "Because of his shining, golden teeth he is also called Gullintani (\"gold tooth\").\n" +
                "\n" +
                "His hall is Himinbjorg, The Cliffs of Heaven, and his horse is Gulltop.\n" +
                "\n" +
                "Heimdall carries the horn Gjallar.\n" +
                "\n" +
                "He is the watchman of the gods and guards Bifrost, the only entrance to Asgard, the realm of the gods.\n" +
                "\n" +
                "It is Heimdall's duty to prevent the giants from forcing their way into Asgard. He requires less sleep than a bird and can see a hundred miles around him, by night as well as by day.\n" +
                "\n" +
                "His hearing is so accurate that no sound escapes him: he can even hear the grass grow or the wool on a sheep's back. At the final conflict of Ragnarok he will kill his age-old enemy, the evil god Loki, but will die himself from his wounds.\n" +
                "\n" +
                "As the god Rig (\"ruler\"), Heimdall created the three races of mankind: the serfs, the peasants, and the warriors. It is interesting to note why Heimdall fathered them, and not Odin as might be expected. Furthermore, Heimdall is in many attributes identical with Tyr."));
        gods.add(new NorseGod("Bragi", "Aesir", "The god of eloquence and poetry, and the patron of skalds (poets) in Norse mythology. He is regarded as a son of Odin and Frigg. Runes were carved on his tongue and he inspired poetry in humans by letting them drink from the mead of poetry. Bragi is married to Idun, the goddess of eternal youth. Oaths were sworn over the Bragarfull (\"Cup of Bragi\"), and drinks were taken from it in honor of a dead king. Before a king ascended the throne, he drank from such a cup."));
        gods.add(new NorseGod("Tyr", "Aesir", "The original Germanic god of war and the patron god of justice, the precursor of Odin. At the time of the Vikings, Tyr had to make way for Odin, who became the god of war himself.\n" +
                "\n" +
                "Tyr was by then regarded as Odin's son (or possibly of the giant Hymir). He is the boldest of the gods, who inspires courage and heroism in battle.\n" +
                "\n" +
                "Tyr is represented as a man with one hand, because his right hand was bitten off by the gigantic wolf Fenrir (in old-Norse, the wrist was called 'wolf-joint').\n" +
                "\n" +
                "His attribute is a spear; the symbol of justice, as well as a weapon.\n" +
                "\n" +
                "At the day of Ragnarok, Tyr will kill the hound Garm, the guardian of the hell, but will die from the wounds inflicted by the animal. In later mythology, \"Tyr\" became to mean \"god\".\n" +
                "\n" +
                "He is also known as T”waz, Tiw and Ziu."));


        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(5, 5, 5, 5));

        Text title = new Text("Norse Gods and other Beings");
        title.setFont(Font.font("TRON.TTF", FontWeight.BOLD, 25));
        borderPane.setTop(title);

        Text name = new Text();
        name.setFont(Font.font("TRON.TTF", FontWeight.BOLD, 20));

        Text race = new Text();
        race.setFont(Font.font("TRON.TTF", FontWeight.BOLD, 10));

        Text desc = new Text();
        desc.setFont(Font.font("TRON.TTF", 18));

        TextFlow textFlow = new TextFlow(name, race, desc);
        textFlow.setPadding(new Insets(10, 10, 10, 10));
        textFlow.setLineSpacing(3);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(textFlow);
        scrollPane.setFitToWidth(true);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        borderPane.setCenter(scrollPane);

        ObservableList<String> names = gods.stream().map(NorseGod::getName).collect(Collectors.toCollection(FXCollections::observableArrayList));

        ListView<String> godList = new ListView<>(names);
        godList.setPrefWidth(150);
        borderPane.setLeft(godList);

        godList.getSelectionModel().selectedIndexProperty().addListener(ov -> {
            name.setText(gods.get(godList.getSelectionModel().getSelectedIndex()).getName() + "\n");
            race.setText(gods.get(godList.getSelectionModel().getSelectedIndex()).getRace() + "\n");
            desc.setText(gods.get(godList.getSelectionModel().getSelectedIndex()).getDesc());
        });

        Scene scene = new Scene(borderPane, 700, 500);
        scene.setFill(Color.LIGHTGREY);
        primaryStage.setTitle("Norse Gods");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
