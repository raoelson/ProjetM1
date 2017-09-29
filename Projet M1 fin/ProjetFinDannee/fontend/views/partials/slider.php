<?php
/**
 * Created by PhpStorm.
 * User: DjazzJah
 * Date: 24/12/2015
 * Time: 14:02
 */
?>
<div class="alert alert-warning" id="alert" style="display: none;">
<button type="button" class="close" data-dismiss="alert">&times;</button>
<p></p>
</div>
<div
	id="myCarousel" class="carousel slide" data-ride="carousel"><!-- Indicators -->
<ol class="carousel-indicators">
	<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
	<li data-target="#myCarousel" data-slide-to="1"></li>
	<li data-target="#myCarousel" data-slide-to="2"></li>
</ol>

<!-- Wrapper for slides -->
<div class="carousel-inner" role="listbox"><?php
if (isset($produits->return)) {
	if (sizeof($produits->return) == 1) {
		?>
<div class="item active"><img
	src="<?php echo base_url($produits->return->imageId->path); ?>"
	alt="..." style="width: 150px; height: 120px;">

<div class="carousel-caption car-re-posn">
<h3><?php echo $produits->return->nom; ?></h3>
<!--<h2><?php /*echo $value->description;*/ ?></h2>--> <span
	class="color-bar"></span></div>
</div>
		<?php
	} else {
		$i = 0;
		foreach ($produits->return as $produits_ => $value) {
			if ($produits_ == 0) $mode = "item active";
			else $mode = "item";
			?>
<div class="<?php echo $mode; ?>"><img
	src="<?php echo base_url($value->imageId->path); ?>" alt="..."
	style="width: 250px; height: 220px;">

<div class="carousel-caption car-re-posn">
<h3><?php echo $value->nom; ?></h3>
<!--<h2><?php /*echo $value->description;*/ ?></h2>--> <span
	class="color-bar"></span></div>
</div>
			<?php

		}
	}
} ?></div>

<!-- Controls --> <a class="left carousel-control" href="#myCarousel"
	role="button" data-slide="prev"> <span
	class="glyphicon glyphicon-chevron-left car-icn" aria-hidden="true"></span>
<span class="sr-only">Previous</span> </a> <a
	class="right carousel-control" href="#myCarousel" role="button"
	data-slide="next"> <span
	class="glyphicon glyphicon-chevron-right car-icn" aria-hidden="true"></span>
<span class="sr-only">Next</span> </a></div>
