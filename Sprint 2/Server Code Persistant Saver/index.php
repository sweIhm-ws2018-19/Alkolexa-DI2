<!-- //**********************************************************************
*
* Project Alkolexa
* @author Anian Weber, weber11@hm.edu
* @version 11.12.2018
*
***********************************************************************/ -->

<?php
$servername = "rdbms.strato.de";
$username = "U3592604";
$password = "das_ist_das_haus_vom_nikolaus";
$dbname = "DB3592604";

$conn = new mysqli($servername, $username, $password, $dbname);
if ($conn->connect_error) {
   die("Connection failed: " . $conn->connect_error);
}


if(!isset($_GET["name"])){
  $sql = "SELECT name FROM favoriten WHERE id=1;";
  $result = mysqli_query($conn, $sql);
  $obj = new \stdClass();
  $obj->name = mysqli_fetch_assoc($result)["name"];
  echo json_encode($obj);
}else{
  $value = ($_GET["name"]);
  $sql = "UPDATE favoriten
  SET name = '$value'
  WHERE id=1;";
  $result = $conn->query($sql);

  $obj = new \stdClass();


  if ($result === TRUE) {
    $obj->status = "success";
    $obj->value = $value;
    echo json_encode($obj);
  } else {
    $obj->status = "error";
    $obj->value = "";
    echo json_encode($obj);
  }
}
$conn->close();
?>
